build-dist:
	gradle clean
	gradle installDist

run:
	./build/install/app/bin/app

run-dist: build-dist run