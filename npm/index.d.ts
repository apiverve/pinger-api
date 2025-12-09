declare module '@apiverve/pinger' {
  export interface pingerOptions {
    api_key: string;
    secure?: boolean;
  }

  export interface pingerResponse {
    status: string;
    error: string | null;
    data: DomainandIPPingerData;
    code?: number;
  }


  interface DomainandIPPingerData {
      host:        string;
      numericHost: string;
      alive:       boolean;
      roundTrips:  number;
      packetLoss:  number;
      minMS:       number;
      avgMS:       number;
      maxMS:       number;
      stdDev:      number;
      times:       number[];
  }

  export default class pingerWrapper {
    constructor(options: pingerOptions);

    execute(callback: (error: any, data: pingerResponse | null) => void): Promise<pingerResponse>;
    execute(query: Record<string, any>, callback: (error: any, data: pingerResponse | null) => void): Promise<pingerResponse>;
    execute(query?: Record<string, any>): Promise<pingerResponse>;
  }
}
