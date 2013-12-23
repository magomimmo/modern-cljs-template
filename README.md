# modern-cljs

A [Leiningen template][1] for creating mixed CLJ/CLJS projects with
batteries included.

## Introduction

CLJ/CLJS (CLJS) newcomers have some difficulties in setting up and
configure a complete environment from which to seriously start
developing with this very powerful programming language for the
browser.

Due to this difficulties most devs just give up and prefer to go back
to the previously used technologies or others programming languages
requiring less efforts in setting up a productive programming
environment.

`modern-cljs` intends to offer to the serious newcomers a more direct
path to start hacking with CLJ/CLJS for building state of the web
applications without immediately incurring in too many incidental
complexities.

## Requirements

The only `modern-cljs` requirements are [Java `>= "1.6"`][2] and
[Leiningen `>= "2.3.4"`][3].

## Installation

### Installing Java

Depending on your machine you could have Java already installed on
it. `modern-cljs` requires a Java Development Kit (JDK) version 6.0 or
later. If you need to install the JDK or to upgrade it, just follow
the instruction for your operating system available on the
[main java website][2].

### Installing Leiningen

After having installed Java you need to install Leiningen. The
available [installation guide][4] is very easy to be followed:

1. Make sure you have a Java JDK version 6 or later;
2. [Download the script][5];
3. Place it on your `$PATH` (cf. `~/bin` is a good choice if it is on your `path`.);
4. Set the script to be executable. (i.e. `chmod 755 ~/bin/lein`);

If you work on Windows, follow [this instruction][6]

## Quick start guide

### Create a new mixed CLJ/CLJS project

```bash
lein new modern-cljs wonderful-webapp --snapshot
Generating a project called wonderful-webapp based on the 'modern-cljs' template
```

### Compile the front-end

A mixed CLJ/CLJS project is composed of a back-end and a back-end. To
be able to run your newly created web-app you need to compile the
front-end which is implemented in CLJS.

```bash
cd wonderful-webapp
lein compile
Compiling ClojureScript.
Compiling "dev-resources/public/js/ws.js" from ["src/cljs" "dev-resources/tools/repl"]...
Successfully compiled "dev-resources/public/js/ws.js" in 18.280974 seconds.
Compiling "resources/public/js/wonderful-webapp.js" from ["src/cljs"]...
Successfully compiled "resources/public/js/wonderful-webapp.js" in 13.458495 seconds.
```

### Run the back-end

```bash
lein ring server-headless
Compiling ClojureScript.
2013-12-23 17:50:18.242:INFO:oejs.Server:jetty-7.6.8.v20121106
2013-12-23 17:50:18.271:INFO:oejs.AbstractConnector:Started SelectChannelConnector@0.0.0.0:3000
Started server on port 3000
```

### Visit the production webapp

Open your browser and visit the [index.html][7] page.

### Activate the bREPL

Open a new terminal, `cd` in the project main directory and issue the
`lein repl` task:

```clojure
cd /path/to/wornderful-webapp
lein repl
Compiling ClojureScript.
nREPL server started on port 54576 on host 127.0.0.1
REPL-y 0.3.0
Clojure 1.5.1
    Docs: (doc function-name-here)
          (find-doc "part-of-name-here")
  Source: (source function-name-here)
 Javadoc: (javadoc java-object-or-class-here)
    Exit: Control+D or (exit) or (quit)
 Results: Stored in vars *1, *2, *3, an exception in *e

user=>
```

Now evaluate the `(browser-repl)` function

```clojure
user=> (browser-repl)
Type `:cljs/quit` to stop the ClojureScript REPL
nil
cljs.user=>
```

Then visit the [index-dbg.html][8] page. Wait a moment to allow the
bREPL to be activated and start evaluating CLJS expressions ar the
bREPL.

```clojure
cljs.user=> (js/alert "Hello")
nil
cljs.user=>
```

Copyright © 2913 Giacomo (Mimmo) Cosenza aka Magomimmo. Released under
the Eclipse Public License, the same as Clojure.

[1]: https://github.com/technomancy/leiningen/blob/master/doc/TEMPLATES.md
[2]: http://www.java.com/en/
[3]: https://github.com/technomancy/leiningen
[4]: https://github.com/technomancy/leiningen#installation
[5]: https://raw.github.com/technomancy/leiningen/stable/bin/lein
[6]: https://github.com/technomancy/leiningen#windows
[7]: http://localhost:3000/index.html
[8]: http://localhost:3000/index-dbg.html

## License

Copyright © Giacomo (Mimmo) Cosenza aka Magomimmo, 2013. Released
under the Eclipse Public License, the same as Clojure.
