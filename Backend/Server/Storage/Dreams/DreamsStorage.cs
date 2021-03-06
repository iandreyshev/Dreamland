﻿using System.Collections.Generic;
using System.Linq;
using Dreamland.Domain;
using Microsoft.EntityFrameworkCore;

namespace Dreamland.Storage.Dreams
{
	public class DreamsStorage : Storage, IDreamsStorage
	{
		private DbSet<Dream> _dreams;

		public DreamsStorage(DatabaseContext context) : base(context)
		{
			_dreams = context.Dreams;
		}

		public long Add(Dream dream)
		{
			var entry = _dreams.Add(dream);
			Context.SaveChanges();

			return entry.Entity.Id;
		}

		public List<Dream> All(long userId)
		{
			var dreams = _dreams.Where(d => d.UserId == userId)
				.OrderBy(x => x.SleepingDate);

			return new List<Dream>(dreams);
		}

		public void Delete(long dreamId)
		{
			var dreams = _dreams.Where(d => d.Id == dreamId);

			if (dreams.Count() == 0)
			{
				return;
			}

			_dreams.Remove(dreams.First());
			Context.SaveChanges();
		}

		public void DeleteAllForUser(long userId)
		{
			var userDreams = _dreams.Where(d => d.UserId == userId);

			foreach (Dream dream in userDreams)
			{
				_dreams.Remove(dream);
			}

			Context.SaveChanges();
		}

		public void Update(Dream dream)
		{
			_dreams.Update(dream);
			Context.SaveChanges();
		}
	}
}
