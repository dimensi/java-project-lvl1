run-dist: # сборка и запуск dist
	gradle clean
	gradle installDist
	./build/install/app/bin/app