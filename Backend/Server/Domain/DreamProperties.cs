using Newtonsoft.Json;

namespace Dreamland.Domain
{
	public class DreamProperties
	{
		[JsonProperty("id", NullValueHandling = NullValueHandling.Ignore)]
		public long Id { get; set; }
		[JsonProperty("description", NullValueHandling = NullValueHandling.Ignore)]
		public string Description { get; set; }
		[JsonProperty("is_lucid", NullValueHandling = NullValueHandling.Ignore)]
		public bool IsLucid { get; set; }
		[JsonProperty("sleeping_date", NullValueHandling = NullValueHandling.Ignore)]
		public long SleepingDate { get; set; }
	}
}
