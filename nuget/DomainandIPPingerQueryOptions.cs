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
        public string Timeout { get; set; }

        /// <summary>
        /// The number of ping retries to attempt
        /// </summary>
        [JsonProperty("retries")]
        public string Retries { get; set; }
    }
}
