package Control.Commands;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import Exception.CommandExecuteException;
import Exception.CommandParseException;
import Logic.Game;

public class SaveCommand extends Command {
	private String nom;
	public SaveCommand() {
		super("Save", "s", "[S]ave <fileName>", "Saves the current state in fileName.dat");
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean execute(Game game) throws CommandExecuteException {
		try {	
			File file= new File(nom);
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			writer.write("Buffy the Vampire Slayer v3.0");
			writer.newLine();
			//writer.newLine();
			writer.write(game.serialize());
			writer.close();
			System.out.println("Game succesfully saved in file " + nom );
			
		}
		catch (IOException e) {
			// TODO: handle exception
			throw new CommandExecuteException("[ERROR]: Failed to save "+nom);
		}
		return false;
	}

	@Override
	public Command parse(String[] commandWords) throws CommandParseException {
			Command com= parseNoParamsCommanddos(commandWords);
			if(com!=null) {
				if(validaLetra(commandWords[1])) {
					nom=commandWords[1]+".dat";
					return com;
				}
			}
			return null;	

	
	}


}
