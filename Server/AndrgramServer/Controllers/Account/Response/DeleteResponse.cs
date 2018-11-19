using Newtonsoft.Json;

namespace Dreamland.Controllers.Account
{
	public class DeleteResponse
	{
		[JsonProperty("error")]
		public string Error { get; set; }
	}
}
