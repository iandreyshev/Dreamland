using Newtonsoft.Json;

namespace Dreamland.Controllers.Account.Response
{
	public class DeleteResponse
	{
		[JsonProperty("error")]
		public string Error { get; set; }
	}
}
