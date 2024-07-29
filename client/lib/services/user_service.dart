import 'dart:convert';
import 'package:client/models/user.dart';
import 'package:http/http.dart' as http;

class UserService {
  Future<List<User>> getUsersExceptUserFollowings(int userId) async {
    final response = await http.get(Uri.parse(
        'http://localhost:8080/api/users/getAll_except_userFollowings?userId=$userId'));
    final data = jsonDecode(response.body);
    final userList =
        List<User>.from(data.map((userJson) => User.fromJson(userJson)));
    return userList;
  }

  Future<void> follow(int userId, int followingId) async {
    http.post(Uri.parse('http://localhost:8080/api/follows/follow?userId=$userId&followingId=$followingId'));
  }
}