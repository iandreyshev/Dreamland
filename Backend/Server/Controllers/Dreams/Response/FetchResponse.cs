﻿using Newtonsoft.Json;
using System.Collections.Generic;

namespace Dreamland.Controllers.Dreams.Response
{
	public class FetchResponse
	{
		[JsonProperty("dreams", NullValueHandling = NullValueHandling.Ignore)]
		public List<DreamResponse> Dreams { get; set; }

		[JsonProperty("error", NullValueHandling = NullValueHandling.Ignore)]
		public string Error { get; set; }
	}
}
