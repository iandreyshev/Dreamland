using System;
using System.ComponentModel.DataAnnotations.Schema;

namespace Dreamland.Domain
{
	[Table("dreams")]
	public class Dream
	{
		[Column("id_dream")]
		public long Id { get; set; }
		[Column("id_user")]
		public long UserId { get; set; }
		[Column("text")]
		public string Description { get; set; }
		[Column("lucid")]
		public int IsLucid { get; set; }
		[Column("sleeping_date")]
		public DateTime SleepingDate { get; set; }
	}
}
