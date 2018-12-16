using Newtonsoft.Json;

namespace Dreamland.Controllers.Dreams.Request
{
	public class RequestDream
	{
		[JsonProperty("dream_id")]
		public long? Id { get; set; }

		[JsonProperty("description")]
		public string Description { get; set; }

		[JsonProperty("is_lucid")]
		public bool IsLucid { get; set; }

		[JsonProperty("sleeping_date")]
		public long SleepingDate { get; set; }
	}
}
