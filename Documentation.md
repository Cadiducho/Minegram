JavaDocs
--------

JavaDocs are currently work in progress, but you can browse source and watch field descriptions.

How to create my bot and get my chat_id?
----------------------------------------

Check this [page](https://github.com/Cadiducho/Minegram/blob/master/Bot.md)

Usage
-----

Minegram is built to use in BukkitPlugins, so you need it installed on your server and added as a [dependency](https://github.com/Cadiducho/Minegram#maven-usage) to your plugin.

Is recommended add dependency on plugin.yml:

```depend: [Minegram]```

This will load Minegram (and all his classes and libs) before your plugin.

```
import com.cadiducho.minegram.BotAPI;
import com.cadiducho.minegram.TelegramBot;
import com.cadiducho.minegram.api.User;
import com.cadiducho.minegram.api.exception.TelegramException;

...

static BotAPI telegramBot;

public void onEnable() {
	telegramBot = new TelegramBot("to:kken", this); //this, or your Bukkit Plugin instance
	
	try {
		User user = telegramBot.getMe();
	} catch(TelegramException e) {
		System.out.println("Could'nt get bot instance!");
	}
}
```

Examples
--------

You can browse a couple of examples [on GitHub repository](https://github.com/Cadiducho/Minegram/tree/master/examples)

