import React, { Fragment } from 'react'

const Footer = () => {
  return (
    <Fragment>
        <footer className="footer-area index-01">
        <div className="footer-top">
            <div className="container custom-container-1515">
                <div className="row">
                    <div className="col-md-12 col-lg-3">
                        <div className="footer-widget">
                            <div className="logo-wrapper">
                                <a href="index.html" className="logo">
                                    <img src="https://bytesed.com/tf/ozagi/assets/img/logo/Logo-01.png" alt="logo"/>
                                </a>
                            </div>
                        </div>
                    </div>
                    <div className="col-md-12 col-lg-6">
                        <div className="footer-widget">
                            <ul className="footer-item-list">
                                <li className="list-item"><a href="#">Home</a></li>
                                <li className="list-item"><a href="#">gallery</a></li>
                                <li className="list-item"><a href="#">about</a></li>
                                <li className="list-item"><a href="#">blog</a></li>
                                <li className="list-item"><a href="#">contact</a></li>
                            </ul>
                        </div>
                    </div>
                    <div className="col-md-12 col-lg-3">
                        <div className="footer-widget">
                            <ul className="social-icon-list">
                                <li className="list-item"><a href="#">
                                        <i className="fab fa-facebook-f icon"></i>
                                    </a></li>
                                <li className="list-item"><a href="#">
                                        <i className="fab fa-twitter icon"></i>
                                    </a></li>
                                <li className="list-item"><a href="#">
                                        <i className="fab fa-instagram icon"></i>
                                    </a></li>
                                <li className="list-item"><a href="#">
                                        <i className="fab fa-google-plus-g icon"></i>
                                    </a></li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div className="footer-bottom">
            <div className="copyright-area">
                <div className="container custom-container-1515">
                    <div className="row">
                        <div className="col-lg-12">
                            <div className="copyright-area-inner">
                                <div className="left-content">
                                    <p className="copyright">Privacy Policy | Terms & Conditions</p>
                                </div>
                                <div className="right-content">
                                    <p className="copyright">All copyright (C) 2021 Reserved</p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </footer>

    <div className="scroll-to-top">
        <i className="fas fa-angle-up"></i>
    </div>
    </Fragment>
  )
}

export default Footer
