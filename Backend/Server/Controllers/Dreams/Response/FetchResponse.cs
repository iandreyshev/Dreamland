using Dreamland.Domain;
using Microsoft.AspNetCore.Server.Kestrel.Internal.System.Collections.Sequences;
using Newtonsoft.Json;

namespace Dreamland.Controllers.Dreams.Response
{
	public class FetchResponse
	{
		[JsonProperty("dreams", NullValueHandling = NullValueHandling.Ignore)]
		public ArrayList<Dream> Dreams { get; set; }

		[JsonProperty("error", NullValueHandling = NullValueHandling.Ignore)]
		public string Error { get; set; }
	}
}
