'use strict';

const e = React.createElement;

class LikeButton extends React.Component {
    render() {
        return e(
            <div class="container secondary col-sm-10 px-0">
                <div class="col-12 bg-light vh-100">
                    <div>
                        <h2>User information-page</h2>
                        <thead>
                        <div class="card">
                            <div><h5 class="card-header">
                                About user
                            </h5>
                            </div>
                            <div class="container-fluid">
                                <table class="table table-striped table-condensed">
                                    <thead>
                                    <tr>
                                        <th>ID</th>
                                        <th>First Name</th>
                                        <th>Last Name</th>
                                        <th>Login</th>
                                        <th>Email</th>
                                        <th>Role</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <tr>
                                    </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                        </thead>
                    </div>
                </div>
            </div>
        );
    }
}

ReactDOM.render(
    <h1>Привет, мир!</h1>,
    document.getElementById('root')
);