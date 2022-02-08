'use strict';

class MyComponent extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            users: []
        };
    }

    componentDidMount() {
        fetch("http://localhost:8080/api/users")
            .then(res => res.json())
            .then(
                (result) => {
                    this.setState({
                        users: result
                    });
                },
            )
    }

    render() {
        const {users} = this.state;
        return (
            <div className="container-fluid">
                <div className="row">
                    <div className="col-2 px-0">
                        <ul className="nav nav-pills flex-column">
                            <li className="nav-item">
                                <a href="/admin" className="nav-link active">Admin</a>
                            </li>
                            <li className="nav-item">
                                <a href="/user" className="nav-link">User</a>
                            </li>
                        </ul>
                    </div>
                    <div className="container secondary col-sm-10 px-0">
                        <div className="col-12 bg-light vh-100">
                            <div><h2>Admin panel</h2>

                                <div className="card">
                                    <ul className="nav nav-tabs" id="myTab" role="tablist">
                                        <li className="nav-item">
                                            <a className="nav-link active" id="profile-tab" data-toggle="tab"
                                               href="#userTable"
                                               role="tab"
                                               aria-controls="profile"
                                               aria-selected="false">userTable</a>
                                        </li>
                                        <li className="nav-item">
                                            <a className="nav-link " id="home-tab" data-toggle="tab" href="#newUser"
                                               role="tab"
                                               aria-controls="home"
                                               aria-selected="true">new User</a>
                                        </li>
                                    </ul>
                                    <div className="tab-content" id="tabContent">
                                        <div className="tab-pane fade show active " id="userTable" role="tabpanel"
                                             aria-labelledby="admin-tab">
                                            <div><h5 className="card-header">All users</h5>
                                                <div className="tab-content">
                                                    <div className="container-fluid">
                                                        <table className="table table-striped table-condensed">
                                                            <thead>
                                                            <tr>
                                                                <th>ID</th>
                                                                <th>First Name</th>
                                                                <th>Last Name</th>
                                                                <th>Username</th>
                                                                <th>Age</th>
                                                                <th>Password</th>
                                                                <th>Email</th>
                                                                <th>Role</th>
                                                                <th>Edit</th>
                                                                <th>Delete</th>
                                                            </tr>
                                                            </thead>
                                                            <tbody>
                                                            {users.map(user => (
                                                                <tr key={user.id}>
                                                                    <td> {user.id}</td>
                                                                    <td> {user.firstName}</td>
                                                                    <td> {user.lastName}</td>
                                                                    <td> {user.username}</td>
                                                                    <td> {user.age}</td>
                                                                    <td> {user.password}</td>
                                                                    <td> {user.email}</td>
                                                                    <td> {user.role}</td>
                                                                    <td>
                                                                        <button className="btn btn-info edit-btn"
                                                                                data-toggle="modal"
                                                                                data-target={"#edit" + user.id}>Edit
                                                                        </button>
                                                                    </td>
                                                                    <td>
                                                                        <button class="btn btn-danger"
                                                                                data-toggle="modal"
                                                                                data-target={"#delete" + user.id}>Delete
                                                                        </button>
                                                                    </td>
                                                                    <div className="modal fade" id={"edit" + user.id}
                                                                         tabIndex="-1"
                                                                         role="dialog">
                                                                        <div className="modal-dialog">
                                                                            <div className="modal-content">
                                                                                <div className="modal-header">
                                                                                    <h5 className="modal-title">Edit
                                                                                        user</h5>
                                                                                    <button type="button"
                                                                                            className="close"
                                                                                            data-dismiss="modal"
                                                                                            aria-label="Close">
                                                                                        <span
                                                                                            aria-hidden="true">&times;</span>
                                                                                    </button>
                                                                                </div>
                                                                                <div className="modal-body text-center">
                                                                                    <form
                                                                                        action={"/api/edit/" + user.id}
                                                                                        method="post"
                                                                                    >

                                                                                        <div className="form-group">
                                                                                            <label
                                                                                                className="font-weight-bold"
                                                                                                htmlFor="id">ID</label>
                                                                                            <input type="text"
                                                                                                   className="form-control"
                                                                                                   value={user.id}
                                                                                                   name="id"
                                                                                                   id="id"
                                                                                                   required/>
                                                                                        </div>

                                                                                        <div className="form-group">
                                                                                            <label
                                                                                                className="font-weight-bold"
                                                                                                htmlFor="editName">First
                                                                                                name</label>
                                                                                            <input type="text"
                                                                                                   className="form-control"
                                                                                                   name="firstName"
                                                                                                   value={user.id}
                                                                                                   id="editName"
                                                                                                   required/>
                                                                                        </div>
                                                                                        <div className="form-group">
                                                                                            <label
                                                                                                className="font-weight-bold"
                                                                                                htmlFor="editLastName">Last
                                                                                                name</label>
                                                                                            <input type="text"
                                                                                                   className="form-control"
                                                                                                   name="lastName"
                                                                                                   value={user.id}
                                                                                                   id="editLastName"
                                                                                                   required/>
                                                                                        </div>
                                                                                        <div className="form-group">
                                                                                            <label
                                                                                                className="font-weight-bold"
                                                                                                htmlFor="editUsername">Username</label>
                                                                                            <input type="text"
                                                                                                   className="form-control"
                                                                                                   name="username"
                                                                                                   value={user.id}
                                                                                                   id="editUsername"
                                                                                                   required/>
                                                                                        </div>
                                                                                        <div className="form-group">
                                                                                            <label
                                                                                                className="font-weight-bold"
                                                                                                htmlFor="editAge">Age</label>
                                                                                            <input type="text"
                                                                                                   className="form-control"
                                                                                                   name="age"
                                                                                                   value={user.id}
                                                                                                   id="editAge"
                                                                                                   required/>
                                                                                        </div>
                                                                                        <div className="form-group">
                                                                                            <label
                                                                                                className="font-weight-bold"
                                                                                                htmlFor="editEmail">Email</label>
                                                                                            <input type="text"
                                                                                                   className="form-control"
                                                                                                   value={user.id}
                                                                                                   name="email"
                                                                                                   id="editEmail"
                                                                                                   required/>
                                                                                        </div>
                                                                                        <div className="form-group">
                                                                                            <label
                                                                                                className="font-weight-bold"
                                                                                                htmlFor="editPassword">Password</label>
                                                                                            <input type="password"
                                                                                                   className="form-control"
                                                                                                   value={user.id}
                                                                                                   name="password"
                                                                                                   id="editPassword"
                                                                                                   required/>
                                                                                        </div>
                                                                                        <div className="form-group">
                                                                                            <label
                                                                                                className="font-weight-bold"
                                                                                                htmlFor="editRoles">Roles</label>
                                                                                            <select multiple size="2"
                                                                                                    className="form-control"
                                                                                                    id="editRoles"
                                                                                                    name="rolez"
                                                                                                    required>
                                                                                                <option
                                                                                                    value={user.id}>
                                                                                                </option>
                                                                                            </select>
                                                                                        </div>
                                                                                        <div className="modal-footer">
                                                                                            <button type="button"
                                                                                                    className="btn btn-secondary"
                                                                                                    data-dismiss="modal">Close
                                                                                            </button>
                                                                                            <button type="submit"
                                                                                                    className="btn btn-primary">Edit
                                                                                            </button>
                                                                                        </div>
                                                                                    </form>
                                                                                </div>

                                                                            </div>
                                                                        </div>
                                                                    </div>
                                                                    <div className="modal fade" id={"delete" + user.id}
                                                                         tabIndex="-1"
                                                                         role="dialog">
                                                                        <div className="modal-dialog">
                                                                            <div className="modal-content">
                                                                                <div className="modal-header">
                                                                                    <h5 className="modal-title">Edit
                                                                                        user</h5>
                                                                                    <button type="button"
                                                                                            className="close"
                                                                                            data-dismiss="modal"
                                                                                            aria-label="Close">
                                                                                        <span
                                                                                            aria-hidden="true">&times;</span>
                                                                                    </button>
                                                                                </div>
                                                                                <div className="modal-body text-center">
                                                                                    <form
                                                                                        action={"/api/delete/" + user.id}
                                                                                        method="post"
                                                                                    >

                                                                                        <div className="form-group">
                                                                                            <label
                                                                                                className="font-weight-bold"
                                                                                                htmlFor="id">ID</label>
                                                                                            <input type="text"
                                                                                                   className="form-control"
                                                                                                   value={user.id}
                                                                                                   name="id"
                                                                                                   id="id"
                                                                                                   required/>
                                                                                        </div>

                                                                                        <div className="form-group">
                                                                                            <label
                                                                                                className="font-weight-bold"
                                                                                                htmlFor="editName">First
                                                                                                name</label>
                                                                                            <input type="text"
                                                                                                   className="form-control"
                                                                                                   name="firstName"
                                                                                                   value={user.id}
                                                                                                   id="editName"
                                                                                                   required/>
                                                                                        </div>
                                                                                        <div className="form-group">
                                                                                            <label
                                                                                                className="font-weight-bold"
                                                                                                htmlFor="editLastName">Last
                                                                                                name</label>
                                                                                            <input type="text"
                                                                                                   className="form-control"
                                                                                                   name="lastName"
                                                                                                   value={user.id}
                                                                                                   id="editLastName"
                                                                                                   required/>
                                                                                        </div>
                                                                                        <div className="form-group">
                                                                                            <label
                                                                                                className="font-weight-bold"
                                                                                                htmlFor="editUsername">Username</label>
                                                                                            <input type="text"
                                                                                                   className="form-control"
                                                                                                   name="username"
                                                                                                   value={user.id}
                                                                                                   id="editUsername"
                                                                                                   required/>
                                                                                        </div>
                                                                                        <div className="form-group">
                                                                                            <label
                                                                                                className="font-weight-bold"
                                                                                                htmlFor="editAge">Age</label>
                                                                                            <input type="text"
                                                                                                   className="form-control"
                                                                                                   name="age"
                                                                                                   value={user.id}
                                                                                                   id="editAge"
                                                                                                   required/>
                                                                                        </div>
                                                                                        <div className="form-group">
                                                                                            <label
                                                                                                className="font-weight-bold"
                                                                                                htmlFor="editEmail">Email</label>
                                                                                            <input type="text"
                                                                                                   className="form-control"
                                                                                                   value={user.id}
                                                                                                   name="email"
                                                                                                   id="editEmail"
                                                                                                   required/>
                                                                                        </div>
                                                                                        <div className="form-group">
                                                                                            <label
                                                                                                className="font-weight-bold"
                                                                                                htmlFor="editPassword">Password</label>
                                                                                            <input type="password"
                                                                                                   className="form-control"
                                                                                                   value={user.id}
                                                                                                   name="password"
                                                                                                   id="editPassword"
                                                                                                   required/>
                                                                                        </div>
                                                                                        <div className="form-group">
                                                                                            <label
                                                                                                className="font-weight-bold"
                                                                                                htmlFor="editRoles">Roles</label>
                                                                                            <select multiple size="2"
                                                                                                    className="form-control"
                                                                                                    id="editRoles"
                                                                                                    name="rolez"
                                                                                                    required>
                                                                                                <option
                                                                                                    value={user.id}>
                                                                                                </option>
                                                                                            </select>
                                                                                        </div>
                                                                                    </form>
                                                                                </div>
                                                                                <div className="modal-footer">
                                                                                    <button type="button"
                                                                                            className="btn btn-secondary"
                                                                                            data-dismiss="modal">Close
                                                                                    </button>
                                                                                    <button type="submit"
                                                                                            className="btn btn-primary">Edit
                                                                                    </button>
                                                                                </div>
                                                                            </div>
                                                                        </div>
                                                                    </div>

                                                                </tr>
                                                            ))}
                                                            </tbody>
                                                        </table>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div className="tab-pane fade" id="newUser" role="tabpanel"
                                             aria-labelledby="new-tab">
                                            <div><h5 className="card-header">Add new user</h5>
                                                <div className="container-fluid bg-white text-center">
                                                    <div className="row">
                                                        <div className="col-4"></div>
                                                        <div className="col-4">
                                                            <form action= {"/api"} method="post">
                                                                <div className="form-group font-weight-bold">
                                                                    <label htmlFor="firstname">First name</label>
                                                                    <input type="text"
                                                                           className="form-control"
                                                                           name="firstName"
                                                                           id="firstname"
                                                                           placeholder="First name"
                                                                           required/>
                                                                </div>
                                                                <div className="form-group font-weight-bold">
                                                                    <label htmlFor="lastName">Last name</label>
                                                                    <input type="text"
                                                                           className="form-control"
                                                                           name="lastName"
                                                                           id="lastName"
                                                                           placeholder="Last name"
                                                                           required/>
                                                                </div>
                                                                <div className="form-group font-weight-bold">
                                                                    <label htmlFor="username">Username</label>
                                                                    <input type="text"
                                                                           className="form-control bg-warning"
                                                                           name="username"
                                                                           id="username"
                                                                           placeholder="Username"
                                                                           required/>
                                                                </div>
                                                                <div className="form-group font-weight-bold">
                                                                    <label htmlFor="age">Age</label>
                                                                    <input type="text"
                                                                           className="form-control"
                                                                           name="age"
                                                                           id="age"
                                                                           placeholder="Age"
                                                                           required/>
                                                                </div>
                                                                <div className="form-group font-weight-bold">
                                                                    <label htmlFor="email">Email</label>
                                                                    <input type="text"
                                                                           className="form-control"
                                                                           name="email"
                                                                           id="email"
                                                                           placeholder="Email"
                                                                           required/>
                                                                </div>
                                                                <div className="form-group font-weight-bold">
                                                                    <label htmlFor="password">Password</label>
                                                                    <input type="password"
                                                                           className="form-control bg-warning"
                                                                           name="password"
                                                                           id="password"
                                                                           placeholder="Password"
                                                                           required/>
                                                                </div>
                                                                <div className="form-group">
                                                                    <label className="font-weight-bold"
                                                                           htmlFor="roles">Roles</label>
                                                                    <select multiple size="2"
                                                                            className="form-control"
                                                                            id="roles"
                                                                            name="rolez"
                                                                            required>
                                                                        <option
                                                                            value="ADMIM">
                                                                        </option>
                                                                    </select>
                                                                </div>
                                                                <div className="form-group">
                                                                    <button type="submit"
                                                                            className="btn btn-success">Add new user
                                                                    </button>
                                                                </div>
                                                            </form>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        );
    }
}

ReactDOM.render(
<MyComponent/>
,
document.getElementById('root')
);



