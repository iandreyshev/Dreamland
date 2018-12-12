using Dreamland.Storage;
using Dreamland.Storage.Account;
using Dreamland.UseCase.Account;
using Microsoft.AspNetCore.Builder;
using Microsoft.AspNetCore.Hosting;
using Microsoft.EntityFrameworkCore;
using Microsoft.Extensions.Configuration;
using Microsoft.Extensions.DependencyInjection;
using System.Data.SqlClient;

public class Startup
{
	public Startup(IConfiguration configuration)
	{
		Configuration = configuration;
	}

	public IConfiguration Configuration { get; }

	// This method gets called by the runtime. Use this method to add services to the container.
	public void ConfigureServices(IServiceCollection services)
	{
		services.AddMvc();

		var conn = new SqlConnection(Configuration.GetConnectionString("Database"));
		conn.Open();

		// UseCase`s
		services.AddTransient<SignInUseCase>();
		services.AddTransient<SignUpUseCase>();
		services.AddTransient<DeleteAccountUseCase>();

		// Storage
		services.AddDbContext<DatabaseContext>(options =>
			options.UseSqlServer(Configuration.GetConnectionString("Database")));
		services.AddTransient<IAccountStorage, AccountStorage>();
	}

	// This method gets called by the runtime. Use this method to configure the HTTP request pipeline.
	public void Configure(IApplicationBuilder app, IHostingEnvironment env)
	{
		if (env.IsDevelopment())
		{
			app.UseDeveloperExceptionPage();
		}

		app.UseStaticFiles();
		app.UseMvc();
	}
}