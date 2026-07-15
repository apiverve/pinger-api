declare module '@apiverve/pinger' {
  export interface pingerOptions {
    api_key: string;
    secure?: boolean;
  }

  /**
   * Describes fields the current plan does not unlock. Locked fields arrive as null
   * in `data`; `locked_fields` names them, using dot paths for nested fields.
   * Absent when the plan unlocks everything.
   */
  export interface PremiumInfo {
    message: string;
    upgrade_url: string;
    locked_fields: string[];
  }

  export interface pingerResponse {
    status: string;
    error: string | null;
    data: DomainandIPPingerData;
    code?: number;
    premium?: PremiumInfo;
  }


  interface DomainandIPPingerData {
      host:        null | string;
      numericHost: null | string;
      alive:       boolean | null;
      roundTrips:  number | null;
      packetLoss:  number | null;
      minMS:       number | null;
      avgMS:       number | null;
      maxMS:       number | null;
      stdDev:      number | null;
      times:       (number | null)[];
  }

  export default class pingerWrapper {
    constructor(options: pingerOptions);

    execute(callback: (error: any, data: pingerResponse | null) => void): Promise<pingerResponse>;
    execute(query: Record<string, any>, callback: (error: any, data: pingerResponse | null) => void): Promise<pingerResponse>;
    execute(query?: Record<string, any>): Promise<pingerResponse>;
  }
}
