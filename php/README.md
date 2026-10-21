# Domain and IP Pinger API - PHP Package

Domain and IP Pinger checks whether any domain name or public IP address is reachable and responding in real time. It returns an alive status and successful round trips, while paid plans add packet loss percentages and latency metrics.

## Installation

Install via Composer:

```bash
composer require apiverve/pinger
```

## Getting Started

Get your API key at [APIVerve](https://apiverve.com)

### Basic Usage

```php
<?php

require_once 'vendor/autoload.php';

use APIVerve\Pinger\Client;

// Initialize the client
$client = new Client('YOUR_API_KEY');

// Make a request
$response = $client->execute([
    'host' => 'google.com',
    'roundTrips' => 1
]);

// Print the response
print_r($response);
```


### Error Handling

```php
use APIVerve\Pinger\Client;
use APIVerve\Pinger\Exceptions\APIException;
use APIVerve\Pinger\Exceptions\ValidationException;

try {
    $response = $client->execute(['host' => 'google.com', 'roundTrips' => 1]);
    print_r($response['data']);
} catch (ValidationException $e) {
    echo "Validation error: " . implode(', ', $e->getErrors());
} catch (APIException $e) {
    echo "API error: " . $e->getMessage();
    echo "Status code: " . $e->getStatusCode();
}
```

### Debug Mode

```php
// Enable debug logging
$client = new Client(
    apiKey: 'YOUR_API_KEY',
    debug: true
);
```

## Example Response

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

## Requirements

- PHP 7.4 or higher
- Guzzle HTTP client

## Documentation

For more information, visit the [API Documentation](https://docs.apiverve.com/ref/pinger?utm_source=packagist&utm_medium=referral&utm_content=readme).

## Support

- Website: [https://apiverve.com/marketplace/pinger?utm_source=php&utm_medium=referral&utm_content=readme](https://apiverve.com/marketplace/pinger?utm_source=php&utm_medium=referral&utm_content=readme)
- Email: hello@apiverve.com

## License

This package is available under the [MIT License](LICENSE).
