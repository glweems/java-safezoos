package com.lambdaschool.zoo;

import com.lambdaschool.zoo.model.Role;
import com.lambdaschool.zoo.model.User;
import com.lambdaschool.zoo.model.UserRoles;
import com.lambdaschool.zoo.repository.RoleRepository;
import com.lambdaschool.zoo.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Transactional
@Component
public class SeedData implements CommandLineRunner
{
    RoleRepository rolerepos;
    UserRepository userrepos;

    public SeedData(RoleRepository rolerepos, UserRepository userrepos)
    {
        this.rolerepos = rolerepos;
        this.userrepos = userrepos;
    }

    @Override
    public void run(String[] args) throws Exception
    {
        Role r1 = new Role("admin");
        Role r2 = new Role("user");

        ArrayList<UserRoles> admins = new ArrayList<>();
        admins.add(new UserRoles(new User(), r1));
        admins.add(new UserRoles(new User(), r2));

        ArrayList<UserRoles> users = new ArrayList<>();
        users.add(new UserRoles(new User(), r2));

        rolerepos.save(r1);
        rolerepos.save(r2);
        User u1 = new User("gw", "pwd", users);
//        u1.getQuotes().add(new Quote("Live long and prosper", u1));
//        u1.getQuotes().add(new Quote("The enemy of my enemy is the enemy I kill last", u1));
//        u1.getQuotes().add(new Quote("Beam me up", u1));

        User u2 = new User("admin", "password", admins);
//        u2.getQuotes().add(new Quote("A creative man is motivated by the desire to achieve, not by the desire to beat others", u2));
//        u2.getQuotes().add(new Quote("The question isn't who is going to let me; it's who is going to stop me.", u2));

        userrepos.save(u1);
        userrepos.save(u2);
    }
}
