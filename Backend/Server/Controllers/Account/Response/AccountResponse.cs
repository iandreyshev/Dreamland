using Newtonsoft.Json;

namespace Dreamland.Controllers.Account.Response
{
	public class AccountResponse
	{
		[JsonProperty("id")]
		public long Id { get; set; }

		[JsonProperty("name")]
		public string Name { get; set; }

		[JsonProperty("avatar_url")]
		public string AvatarUrl { get; set; }
	}
}
