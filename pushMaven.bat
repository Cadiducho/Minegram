@ECHO OFF
title Maven automatic deploy
echo Pushing latest version to Maven Repository
mvn deploy
echo Repo.cadiducho.com updated with latest artifact of Minegram
pause < nul