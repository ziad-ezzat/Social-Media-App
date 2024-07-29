class User {
  int? id;
  String name;
  String lastName;
  String email;
  String? password;

  User({
    this.id,
    required this.name,
    required this.lastName,
    required this.email,
    this.password,
  });

  static fromJson(userJson) {
    return User(
      id: userJson['id'],
      name: userJson['name'],
      lastName: userJson['lastName'],
      email: userJson['email'],
    );
  }
}
