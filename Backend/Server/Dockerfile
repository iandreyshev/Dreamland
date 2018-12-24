FROM microsoft/aspnetcore:2.0-nanoserver-sac2016 AS base
WORKDIR /app
EXPOSE 80

FROM microsoft/aspnetcore-build:2.0-nanoserver-sac2016 AS build
WORKDIR /src
COPY Server/Dreamland.csproj Server/
RUN dotnet restore Server/Dreamland.csproj
COPY . .
WORKDIR /src/Server
RUN dotnet build Dreamland.csproj -c Release -o /app

FROM build AS publish
RUN dotnet publish Dreamland.csproj -c Release -o /app

FROM base AS final
WORKDIR /app
COPY --from=publish /app .
ENTRYPOINT ["dotnet", "Dreamland.dll"]
