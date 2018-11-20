@ECHO OFF

IF "%~1"=="" (
  GOTO InvalidArgs
)

SET BUILD_DIR=Build/Server_v%~1
SET CONFIG_DIR=config
SET CONFIG_EXT=json
SET SRC_DIR=Backend
SET PROJECT_DIR=Server
SET PROJECT_NAME=Dreamland
SET BACKEND_CONFIG=%SRC_DIR%\%PROJECT_DIR%\config.%CONFIG_EXT%
SET BACKEND_WINDOW_NAME=%BUILD_DIR%

SET PROPERTIES_FILE_PATH=%CONFIG_DIR%\properties.cfg

CALL :Clear

CALL :Build
IF %ERRORLEVEL% NEQ 0 GOTO BuildError

CALL :CopyConfig
IF %ERRORLEVEL% NEQ 0 GOTO CopyConfigsError

CALL :CreateRunScript
CALL :CreateStopScript
CALL :CreateProperties

ECHO Build completed!
EXIT /B 0

:Clear
  IF EXIST %BUILD_DIR% RD /s /q "%BUILD_DIR%"
  EXIT /B 0

:Build
  CALL :BuildComponent %PROJECT_DIR%
  IF %ERRORLEVEL% NEQ 0 EXIT /B 1

  EXIT /B 0

:BuildComponent
  dotnet publish %SRC_DIR%\%~1 -c Release -o ..\..\%BUILD_DIR%\%~1
  IF %ERRORLEVEL% NEQ 0 EXIT /B 1
  EXIT /B 0

:CopyConfig
  MD "%BUILD_DIR%\%CONFIG_DIR%"
  COPY "%BACKEND_CONFIG%" "%BUILD_DIR%\%CONFIG_DIR%\%PROJECT_NAME%.%CONFIG_EXT%"
  IF %ERRORLEVEL% NEQ 0 EXIT /B 1
  EXIT /B 0

:CreateRunScript
  SET DEST_FILE=%BUILD_DIR%\run.cmd
  SET A=%%%%A
  SET B=%%%%B
  SET VCC=%%VowelConsCounter%%
  SET VCR=%%VowelConsRater%%

  @ECHO @ECHO OFF                                                                                           > %DEST_FILE%
  @ECHO copy "%CONFIG_DIR%\%PROJECT_NAME%.%CONFIG_EXT%" "%PROJECT_DIR%\config.%CONFIG_EXT%"               >> %DEST_FILE%
  @ECHO start "%BACKEND_WINDOW_NAME%" dotnet %PROJECT_DIR%\%PROJECT_NAME%.dll                             >> %DEST_FILE%
  EXIT /B 0

:CreateStopScript
  (
    @ECHO @ECHO OFF
    @ECHO taskkill /IM dotnet.exe
  ) > %BUILD_DIR%\stop.cmd
  EXIT /B 0

:CreateProperties
  @ECHO Hello, World! > %BUILD_DIR%\%PROPERTIES_FILE_PATH%
  (
    @ECHO VowelConsCounter=1
    @ECHO VowelConsRater=1
  ) > %BUILD_DIR%\%PROPERTIES_FILE_PATH%
  EXIT /B 0

:InvalidArgs
  ECHO Invalid build version. Usage: build.cmd version
  EXIT /B 1

:BuildError
  ECHO Error during build project...
  CALL :Clear
  EXIT /B 2

:CopyConfigsError
  ECHO Error during copy config files...
  CALL :Clear
  EXIT /B 3
