using System.ComponentModel.DataAnnotations.Schema;

namespace Dreamland.Domain
{
	[Table("users")]
	public class User
	{
		[Column("id_user")]
		public long Id { get; set; }
		[Column("email")]
		public string Email { get; set; }
		[Column("password")]
		public string Password { get; set; }
		[Column("name")]
		public string Name { get; set; }
		[Column("avatar_url")]
		public string AvatarUrl { get; set; }
	}
}