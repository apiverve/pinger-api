using System;
using System.Collections.Generic;
using System.Text;
using Newtonsoft.Json;

namespace APIVerve.API.DomainandIPPinger
{
    /// <summary>
    /// Query options for the Domain and IP Pinger API
    /// </summary>
    public class DomainandIPPingerQueryOptions
    {
        /// <summary>
        /// The host name or public IP that you want to ping
        /// </summary>
        [JsonProperty("host")]
        public string Host { get; set; }

        /// <summary>
        /// The timeout for the ping request in milliseconds
        /// </summary>
        [JsonProperty("timeout")]
        public int? Timeout { get; set; }

        /// <summary>
        /// How many pings to send before averaging the round-trip time
        /// </summary>
        [JsonProperty("roundTrips")]
        public int? RoundTrips { get; set; }
    }
}
