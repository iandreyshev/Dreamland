using Newtonsoft.Json;

namespace Dreamland.Controllers.Dreams.Response
{
	public class DeleteResponse
	{
		[JsonProperty("error", NullValueHandling = NullValueHandling.Ignore)]
		public string Error { get; set; }
	}
}
