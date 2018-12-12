using Dreamland.Domain;
using Microsoft.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore.Storage;
using System;

namespace Dreamland.Storage
{
	public class DatabaseContext : DbContext
	{
		public DbSet<User> Users { get; set; }

		public DatabaseContext(DbContextOptions<DatabaseContext> options) : base(options)
		{
			Database.OpenConnection();
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
