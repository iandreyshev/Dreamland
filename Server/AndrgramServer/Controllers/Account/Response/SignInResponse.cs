using Newtonsoft.Json;

namespace Dreamland.Controllers.Account
{
	public class SignInResponse
	{
		[JsonProperty("account", NullValueHandling = NullValueHandling.Ignore)]
		public AccountResponse Account { get; set; }

		[JsonProperty("error", NullValueHandling = NullValueHandling.Ignore)]
		public string Error { get; set; }
	}
}
