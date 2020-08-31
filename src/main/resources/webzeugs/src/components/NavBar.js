import React from 'react'
import AppBar from '@material-ui/core/AppBar';
import Toolbar from '@material-ui/core/Toolbar';
import Typography from '@material-ui/core/Typography';
import { MenuItem } from '@material-ui/core';

import { HashRouter, Link } from "react-router-dom";

const NavBar = () => {
    return(
        <HashRouter>
            <div>
                <AppBar position="static">
                    <Toolbar>
                        <MenuItem component={Link} to="/">
                            <Typography variant='h6'>
                                Home
                            </Typography>
                        </MenuItem>
                        <MenuItem component={Link} to="/staff">
                            <Typography variant='h6'>
                                Staff
                            </Typography>
                        </MenuItem>
                        <MenuItem component={Link} to="/animals">
                            <Typography variant='h6'>
                                Animals
                            </Typography>
                        </MenuItem>
                        <MenuItem component={Link} to="/transactions">
                            <Typography variant='h6'>
                                Transactions
                            </Typography>
                        </MenuItem>
                        <MenuItem  component={Link} to="/shops">
                            <Typography variant='h6'>
                                Shops
                            </Typography>
                        </MenuItem>
                        <MenuItem  component={Link} to="/enclosures">
                            <Typography variant='h6'>
                                Gehege
                            </Typography>
                        </MenuItem>
                        
                    </Toolbar>
                </AppBar>
            </div>
        </HashRouter>
    )
}

export default NavBar;