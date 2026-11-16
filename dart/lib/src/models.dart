/// Response models for the Domain and IP Pinger API.

/// API Response wrapper.
class PingerResponse {
  final String status;
  final dynamic error;
  final PingerData? data;

  /// Set only when the current plan locks one or more fields; null otherwise.
  final PremiumInfo? premium;

  PingerResponse({
    required this.status,
    this.error,
    this.data,
    this.premium,
  });

  factory PingerResponse.fromJson(Map<String, dynamic> json) => PingerResponse(
    status: json['status'] as String? ?? '',
    error: json['error'],
    data: json['data'] != null ? PingerData.fromJson(json['data']) : null,
    premium: json['premium'] != null ? PremiumInfo.fromJson(json['premium']) : null,
  );

  Map<String, dynamic> toJson() => {
    'status': status,
    if (error != null) 'error': error,
    if (data != null) 'data': data,
    if (premium != null) 'premium': premium!.toJson(),
  };
}

/// Describes fields the current plan does not unlock. Locked fields arrive as null
/// in [data], and [lockedFields] names them (nested ones use dot paths).
class PremiumInfo {
  final String? message;
  final String? upgradeUrl;
  final List<String>? lockedFields;

  PremiumInfo({this.message, this.upgradeUrl, this.lockedFields});

  factory PremiumInfo.fromJson(Map<String, dynamic> json) => PremiumInfo(
    message: json['message'] as String?,
    upgradeUrl: json['upgrade_url'] as String?,
    lockedFields: (json['locked_fields'] as List?)?.map((e) => e.toString()).toList(),
  );

  Map<String, dynamic> toJson() => {
    if (message != null) 'message': message,
    if (upgradeUrl != null) 'upgrade_url': upgradeUrl,
    if (lockedFields != null) 'locked_fields': lockedFields,
  };
}

/// Response data for the Domain and IP Pinger API.

class PingerData {
  String? host;
  String? numericHost;
  bool? alive;
  num? roundTrips;
  num? packetLoss;
  num? minMS;
  num? avgMS;
  num? maxMS;
  num? stdDev;
  List<num>? times;

  PingerData({
    this.host,
    this.numericHost,
    this.alive,
    this.roundTrips,
    this.packetLoss,
    this.minMS,
    this.avgMS,
    this.maxMS,
    this.stdDev,
    this.times,
  });

  factory PingerData.fromJson(Map<String, dynamic> json) => PingerData(
      host: json['host'],
      numericHost: json['numericHost'],
      alive: json['alive'],
      roundTrips: json['roundTrips'],
      packetLoss: json['packetLoss'],
      minMS: json['minMS'],
      avgMS: json['avgMS'],
      maxMS: json['maxMS'],
      stdDev: json['stdDev'],
      times: (json['times'] as List?)?.cast<num>(),
    );
}

class PingerRequest {
  String host;
  num? roundTrips;

  PingerRequest({
    required this.host,
    this.roundTrips,
  });

  Map<String, dynamic> toJson() => {
      'host': host,
      if (roundTrips != null) 'roundTrips': roundTrips,
    };
}
