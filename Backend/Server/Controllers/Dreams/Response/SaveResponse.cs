using Newtonsoft.Json;

namespace Dreamland.Controllers.Dreams.Response
{
	public class SaveResponse
	{
		[JsonProperty("dream_id", NullValueHandling = NullValueHandling.Ignore)]
		public long? DreamId { get; set; }

		[JsonProperty("error", NullValueHandling = NullValueHandling.Ignore)]
		public string Error { get; set; }
	}
}
