using Newtonsoft.Json;

namespace Dreamland.Controllers.Dreams.Response
{
	public class FetchResponse
	{
		[JsonProperty("dreams", NullValueHandling = NullValueHandling.Ignore)]
		public DreamResponse[] Dreams { get; set; }

		[JsonProperty("error", NullValueHandling = NullValueHandling.Ignore)]
		public string Error { get; set; }
	}
}
