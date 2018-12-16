using Dreamland.Domain;
using Microsoft.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore.Storage;
using Microsoft.Extensions.Configuration;
using System;

namespace Dreamland.Storage
{
	public class DatabaseContext : DbContext
	{
		public DbSet<User> Users { get; set; }
		public DbSet<Dream> Dreams { get; set; }

		private IConfiguration Configuration { get; }

		public DatabaseContext(
			DbContextOptions<DatabaseContext> options,
			IConfiguration configuration) : base(options)
		{
			Configuration = configuration;
		}

		protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder)
		{
			optionsBuilder.UseMySQL(Configuration.GetConnectionString("Database"));
		}

		public TResult Transaction<TResult>(TResult errVal, Func<int, TResult> body)
		{
			using (IDbContextTransaction t = Database.BeginTransaction())
			{
				try
				{
					var result = body(0);
					t.Commit();
					return result;
				}
				catch (Exception ex)
				{
					t.Rollback();
					return errVal;
				}
			}
		}
	}
}
