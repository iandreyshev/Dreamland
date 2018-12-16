using System;

namespace Dreamland.Storage
{
	public interface IStorage
	{
		TResult Transaction<TResult>(TResult errVal, Func<int, TResult> body);
	}
}
