package io.github.axle2005.dimreseter.commands;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.command.args.GenericArguments;
import org.spongepowered.api.command.spec.CommandSpec;
import org.spongepowered.api.text.Text;

import io.github.axle2005.dimreseter.Config;
import io.github.axle2005.dimreseter.DimReseter;


public class Register {

	public Register(DimReseter plugin, Config config) {
		CommandSpec add = CommandSpec.builder().permission("dimreset.manage.add")
				.description(Text.of("Add Dim to Config"))
				.arguments(GenericArguments.onlyOne(GenericArguments.string(Text.of("Dim|Here"))))
				.executor(new CommandDimAdd(plugin, config)).build();

		CommandSpec dimreset = CommandSpec.builder().description(Text.of("ClearMob Command")).child(add, "add")

				.build();

		Sponge.getCommandManager().register(plugin, dimreset, "DimReseter");
	}
}