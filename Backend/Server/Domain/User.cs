﻿namespace Dreamland.Domain
{
	public class User
	{
		public long Id { get; set; }
		public string Email { get; set; }
		public string Password { get; set; }
		public string Name { get; set; }
		public string AvatarUrl { get; set; }
	}
}