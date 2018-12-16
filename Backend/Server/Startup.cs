using Dreamland.Storage;
using Dreamland.Storage.Account;
using Dreamland.Storage.Dreams;
using Dreamland.UseCase.Account;
using Dreamland.UseCase.Dreams;
using Microsoft.AspNetCore.Builder;
using Microsoft.AspNetCore.Hosting;
using Microsoft.Extensions.Configuration;
using Microsoft.Extensions.DependencyInjection;

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

		// Account useCase`s
		services.AddTransient<SignInUseCase>();
		services.AddTransient<SignUpUseCase>();
		services.AddTransient<DeleteAccountUseCase>();

		// Dreams useCase`s
		services.AddTransient<FetchUseCase>();
		services.AddTransient<SaveUseCase>();
		services.AddTransient<EditUseCase>();
		services.AddTransient<DeleteDreamUseCase>();

		// Storage
		services.AddDbContext<DatabaseContext>();
		services.AddTransient<IAccountStorage, AccountStorage>();
		services.AddTransient<IDreamsStorage, DreamsStorage>();
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