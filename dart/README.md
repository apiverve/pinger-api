# Domain and IP Pinger API - Dart/Flutter Client

Domain and IP Pinger checks whether any domain name or public IP address is reachable and responding in real time. It returns an alive status and successful round trips, while paid plans add packet loss percentages and latency metrics.

[![pub package](https://img.shields.io/pub/v/apiverve_pinger.svg)](https://pub.dev/packages/apiverve_pinger)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

This is the Dart/Flutter client for the [Domain and IP Pinger API](https://apiverve.com/marketplace/pinger?utm_source=dart&utm_medium=referral&utm_content=readme).

## Installation

Add this to your `pubspec.yaml`:

```yaml
dependencies:
  apiverve_pinger: ^1.2.6
```

Then run:

```bash
dart pub get
# or for Flutter
flutter pub get
```

## Usage

```dart
import 'package:apiverve_pinger/apiverve_pinger.dart';

void main() async {
  final client = PingerClient('YOUR_API_KEY');

  try {
    final response = await client.execute({
      'host': 'google.com',
      'roundTrips': 1
    });

    print('Status: ${response.status}');
    print('Data: ${response.data}');
  } catch (e) {
    print('Error: $e');
  }
}
```

## Response

```json
{
  "status": "ok",
  "error": null,
  "data": {
    "host": "google.com",
    "numericHost": "2607:f8b0:4001:c6e::8a",
    "alive": true,
    "roundTrips": 3,
    "packetLoss": 0,
    "minMS": 0.652,
    "avgMS": 0.6846666666666666,
    "maxMS": 0.712,
    "stdDev": 0.02478350706058811,
    "times": [
      0.712,
      0.652,
      0.69
    ]
  }
}
```

## API Reference

- **API Home:** [Domain and IP Pinger API](https://apiverve.com/marketplace/pinger?utm_source=dart&utm_medium=referral&utm_content=readme)
- **Documentation:** [docs.apiverve.com/ref/pinger](https://docs.apiverve.com/ref/pinger?utm_source=dart&utm_medium=referral&utm_content=readme)

## Authentication

All requests require an API key. Get yours at [apiverve.com](https://apiverve.com?utm_source=dart&utm_medium=referral&utm_content=readme).

## License

MIT License - see [LICENSE](LICENSE) for details.

---

Built with Dart for [APIVerve](https://apiverve.com?utm_source=dart&utm_medium=referral&utm_content=readme)
