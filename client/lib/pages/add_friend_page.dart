import 'package:flutter/material.dart';
import 'package:client/models/user.dart';
import 'package:client/services/user_service.dart';

class UserListPage extends StatefulWidget {
  const UserListPage({super.key});

  @override
  _UserListPageState createState() => _UserListPageState();
}

class _UserListPageState extends State<UserListPage> {
  late Future<List<User>> futureUsers;
  List<User> allUsers = [];
  List<User> filteredUsers = [];
  bool isSearching = false;
  final TextEditingController searchController = TextEditingController();

  @override
  void initState() {
    super.initState();
    futureUsers = UserService().getUsersExceptUserFollowings(1);
    futureUsers.then((users) {
      setState(() {
        allUsers = users;
        filteredUsers = users;
      });
    });
  }

  void filterUsers(String query) {
    final filtered = allUsers.where((user) {
      final name = user.name.toLowerCase();
      final lastName = user.lastName.toLowerCase();
      final searchLower = query.toLowerCase();
      return name.contains(searchLower) || lastName.contains(searchLower);
    }).toList();
    setState(() {
      filteredUsers = filtered;
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: !isSearching
            ? const Text('Add Friends')
            : TextField(
                controller: searchController,
                decoration: const InputDecoration(
                  hintText: 'Search...',
                ),
                onChanged: (query) => filterUsers(query),
              ),
        leading: IconButton(
          icon: const Icon(Icons.arrow_back),
          onPressed: () {
            if (isSearching) {
              setState(() {
                isSearching = false;
                filteredUsers = allUsers;
                searchController.clear();
              });
            } else {
              Navigator.pop(context);
            }
          },
        ),
        actions: [
          IconButton(
            icon: const Icon(Icons.search),
            onPressed: () {
              setState(() {
                isSearching = !isSearching;
                if (!isSearching) {
                  filteredUsers = allUsers;
                  searchController.clear();
                }
              });
            },
          ),
        ],
      ),
      body: FutureBuilder<List<User>>(
        future: futureUsers,
        builder: (context, snapshot) {
          if (snapshot.connectionState == ConnectionState.waiting) {
            return const Center(child: CircularProgressIndicator());
          } else if (snapshot.hasError) {
            return Center(child: Text('Error: ${snapshot.error}'));
          } else if (!snapshot.hasData || snapshot.data!.isEmpty) {
            return const Center(child: Text('No users found'));
          } else {
            return ListView.builder(
              itemCount: filteredUsers.length,
              itemBuilder: (context, index) {
                final user = filteredUsers[index];
                return ListTile(
                  leading: const CircleAvatar(
                    backgroundImage: NetworkImage(
                        'https://img.freepik.com/premium-vector/user-profile-icon-flat-style-member-avatar-vector-illustration-isolated-background-human-permission-sign-business-concept_157943-15752.jpg'),
                  ),
                  title: Text('${user.name} ${user.lastName}'),
                  subtitle: Text(
                    user.email,
                    style: const TextStyle(
                      fontSize: 12,
                      color: Colors.grey,
                    ),
                  ),
                  trailing: ElevatedButton(
                    style: ButtonStyle(
                      backgroundColor: WidgetStateProperty.all(Colors.green),
                    ),
                    onPressed: () {
                      UserService().follow(1, user.id!);
                      setState(() {
                        allUsers.remove(user);
                        filteredUsers.remove(user);
                      });
                    },
                    child: const Text(
                      'Follow',
                      style: TextStyle(color: Colors.white),
                    ),
                  ),
                );
              },
            );
          }
        },
      ),
    );
  }
}