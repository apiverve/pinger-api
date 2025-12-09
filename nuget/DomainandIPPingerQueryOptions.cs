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
        /// Example: google.com
        /// </summary>
        [JsonProperty("host")]
        public string Host { get; set; }

        /// <summary>
        /// The timeout for the ping request (in milliseconds). Default is 1000 milliseconds. Max is 3000
        /// Example: 1000
        /// </summary>
        [JsonProperty("timeout")]
        public string Timeout { get; set; }
    }
}
