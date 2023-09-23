Console console = System.console();

        String contraseña = console.readPassword("Enter your password: ");

        console.flush();

        for (int i = 0; i < password.length(); i++) {
            System.out.print("*");
        }
        System.out.println();
