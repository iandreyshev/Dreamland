using System;
using System.Collections.Generic;
using Dreamland.Domain;

namespace Dreamland.Storage.Dreams
{
	public class DreamsStorage : Storage, IDreamsStorage
	{
		public DreamsStorage(DatabaseContext context) : base(context)
		{

		}

		public void Add(Dream dream)
		{
			throw new System.NotImplementedException();
		}

		public List<Dream> All()
		{
			throw new System.NotImplementedException();
		}

		public void Delete(long dreamId)
		{
			throw new System.NotImplementedException();
		}

		public void Update(Dream dream)
		{
			throw new System.NotImplementedException();
		}
	}
}
