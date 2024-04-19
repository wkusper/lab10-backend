@echo off

docker "compose" "down" "--volumes" && docker "compose" "up" "--build"


