using Dreamland.Domain;
using System.Collections.Generic;

namespace Dreamland.Storage.Dreams
{
	public interface IDreamsStorage : IStorage
	{
		List<Dream> All(long userId);
		long Add(Dream dream);
		void Update(Dream dream);
		void Delete(long dreamId);
		void DeleteAllForUser(long userId);
	}
}
