using Newtonsoft.Json;

namespace Dreamland.Controllers.Dreams.Response
{
	public class EditReponse
	{
		[JsonProperty("error", NullValueHandling = NullValueHandling.Ignore)]
		public string Error { get; set; }
	}
}
