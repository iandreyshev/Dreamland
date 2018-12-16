using System;

namespace Dreamland.Storage
{
	public class Storage
	{
		protected DatabaseContext Context { get; set; }

		public Storage(DatabaseContext context)
		{
			Context = context;
		}

		public TResult Transaction<TResult>(TResult errVal, Func<int, TResult> body)
			=> Context.Transaction(errVal, body);
	}
}
