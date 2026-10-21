# Domain and IP Pinger API - Ruby Gem

Domain and IP Pinger checks whether any domain name or public IP address is reachable and responding in real time. It returns an alive status and successful round trips, while paid plans add packet loss percentages and latency metrics.

## Installation

Add this line to your application's Gemfile:

```ruby
gem 'apiverve_pinger'
```

And then execute:

```bash
$ bundle install
```

Or install it yourself as:

```bash
$ gem install apiverve_pinger
```

## Getting Started

Get your API key at [APIVerve](https://apiverve.com)

### Basic Usage

```ruby
require 'apiverve_pinger'

# Initialize the client
client = APIVerve::Pinger::Client.new(api_key: "YOUR_API_KEY")

# Make a request
response = client.execute({
  host: "google.com",
  roundTrips: 1
})

# Print the response
puts response
```


### Error Handling

```ruby
begin
  response = client.execute({ host: "google.com", roundTrips: 1 })
  puts response["data"]
rescue APIVerve::Pinger::ValidationError => e
  puts "Validation error: #{e.errors.join(', ')}"
rescue APIVerve::Pinger::APIError => e
  puts "API error: #{e.message}"
  puts "Status code: #{e.status_code}"
end
```

### Debug Mode

```ruby
# Enable debug logging
client = APIVerve::Pinger::Client.new(
  api_key: "YOUR_API_KEY",
  debug: true
)
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

## Documentation

For more information, visit the [API Documentation](https://docs.apiverve.com/ref/pinger?utm_source=rubygems&utm_medium=referral&utm_content=readme).

## Support

- Website: [https://apiverve.com/marketplace/pinger?utm_source=ruby&utm_medium=referral&utm_content=readme](https://apiverve.com/marketplace/pinger?utm_source=ruby&utm_medium=referral&utm_content=readme)
- Email: hello@apiverve.com

## License

This gem is available under the [MIT License](LICENSE).
