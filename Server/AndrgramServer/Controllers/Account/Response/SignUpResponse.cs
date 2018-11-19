using Newtonsoft.Json;

namespace Dreamland.Controllers.Account
{
	public class SignUpResponse
	{
		[JsonProperty("account", NullValueHandling = NullValueHandling.Ignore)]
		public AccountResponse Account { get; set; }

		[JsonProperty("error")]
		public string Error { get; set; }
	}
}
