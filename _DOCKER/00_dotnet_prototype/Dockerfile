FROM mcr.microsoft.com/dotnet/aspnet:5.0
WORKDIR /app
EXPOSE 80
COPY ./obj/Docker/publish .
ENTRYPOINT ["dotnet", "prototype.dll"]